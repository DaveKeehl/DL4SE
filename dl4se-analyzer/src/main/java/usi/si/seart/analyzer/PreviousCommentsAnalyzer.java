package usi.si.seart.analyzer;

import usi.si.seart.analyzer.traverser.PreviousCommentTraverser;
import usi.si.seart.analyzer.traverser.Traverser;
import usi.si.seart.analyzer.util.stream.DelimiterSuffixedStringCollector;
import usi.si.seart.model.code.Function;
import usi.si.seart.treesitter.Language;
import usi.si.seart.treesitter.Node;

import java.nio.file.Path;
import java.util.List;

public abstract class PreviousCommentsAnalyzer extends AbstractAnalyzer {

    protected Traverser<List<Node>> previousCommentTraverser = new PreviousCommentTraverser();

    protected PreviousCommentsAnalyzer(LocalClone localClone, Path path, Language language) {
        super(localClone, path, language);
    }

    @Override
    protected Function extractFunctionEntity(Node node) {
        List<Node> comments = previousCommentTraverser.getNodes(node);
        String doc = comments.stream()
                .map(comment -> nodePrinter.print(comment))
                .collect(new DelimiterSuffixedStringCollector("\n"));
        String docAst = comments.stream()
                .map(comment -> syntaxTreePrinter.print(comment))
                .collect(new DelimiterSuffixedStringCollector("\n"));
        String docSExpression = comments.stream()
                .map(comment -> sExpressionPrinter.print(comment))
                .collect(new DelimiterSuffixedStringCollector(" "));
        Long docLines = comments.stream()
                .mapToLong(comment -> lineCounter.count(comment))
                .sum();
        Long docTotalTokens = comments.stream()
                .mapToLong(comment -> totalTokenCounter.count(comment))
                .sum();
        Long docCharacters = comments.stream()
                .mapToLong(comment -> characterCounter.count(comment))
                .sum();
        boolean docContainsNonAscii = comments.stream()
                .anyMatch(comment -> containsNonAscii.test(comment));

        return Function.builder()
                .repo(localClone.getGitRepo())
                .content(doc + nodePrinter.print(node))
                .contentHash(contentHasher.hash(node))
                .ast(docAst + syntaxTreePrinter.print(node))
                .astHash(syntaxTreeHasher.hash(node))
                .sExpression("(sexp " + docSExpression + sExpressionPrinter.print(node)+")")
                .totalTokens(docTotalTokens + totalTokenCounter.count(node))
                .codeTokens(codeTokenCounter.count(node))
                .lines(docLines + lineCounter.count(node))
                .characters(docCharacters + characterCounter.count(node))
                .containsNonAscii(docContainsNonAscii || containsNonAscii.test(node))
                .containsError(containsError.test(node))
                .boilerplateType(boilerplateEnumerator.asEnum(node))
                .build();
    }
}
