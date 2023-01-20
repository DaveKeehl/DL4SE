/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class usi_si_seart_treesitter_TreeSitter */

#ifndef _Included_usi_si_seart_treesitter_TreeSitter
#define _Included_usi_si_seart_treesitter_TreeSitter
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeChild
 * Signature: (Lusi/si/seart/treesitter/Node;I)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeChild
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeChildByFieldName
 * Signature: (Lusi/si/seart/treesitter/Node;Ljava/lang/String;)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeChildByFieldName
  (JNIEnv *, jclass, jobject, jstring);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeChildCount
 * Signature: (Lusi/si/seart/treesitter/Node;)I
 */
JNIEXPORT jint JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeChildCount
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeDescendantForByteRange
 * Signature: (Lusi/si/seart/treesitter/Node;II)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeDescendantForByteRange
  (JNIEnv *, jclass, jobject, jint, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeEndByte
 * Signature: (Lusi/si/seart/treesitter/Node;)I
 */
JNIEXPORT jint JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeEndByte
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeEndPoint
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Point;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeEndPoint
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeEq
 * Signature: (Lusi/si/seart/treesitter/Node;Lusi/si/seart/treesitter/Node;)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeEq
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeFieldNameForChild
 * Signature: (Lusi/si/seart/treesitter/Node;I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeFieldNameForChild
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeFirstChildForByte
 * Signature: (Lusi/si/seart/treesitter/Node;I)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeFirstChildForByte
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeFirstNamedChildForByte
 * Signature: (Lusi/si/seart/treesitter/Node;I)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeFirstNamedChildForByte
  (JNIEnv *, jclass, jobject, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeHasError
 * Signature: (Lusi/si/seart/treesitter/Node;)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeHasError
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeIsExtra
 * Signature: (Lusi/si/seart/treesitter/Node;)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeIsExtra
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeIsMissing
 * Signature: (Lusi/si/seart/treesitter/Node;)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeIsMissing
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeIsNamed
 * Signature: (Lusi/si/seart/treesitter/Node;)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeIsNamed
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeIsNull
 * Signature: (Lusi/si/seart/treesitter/Node;)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeIsNull
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeParent
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeParent
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodePrevNamedSibling
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodePrevNamedSibling
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodePrevSibling
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodePrevSibling
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeNextNamedSibling
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeNextNamedSibling
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeNextSibling
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeNextSibling
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeStartByte
 * Signature: (Lusi/si/seart/treesitter/Node;)I
 */
JNIEXPORT jint JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeStartByte
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeStartPoint
 * Signature: (Lusi/si/seart/treesitter/Node;)Lusi/si/seart/treesitter/Point;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeStartPoint
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeString
 * Signature: (Lusi/si/seart/treesitter/Node;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeString
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    nodeType
 * Signature: (Lusi/si/seart/treesitter/Node;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_usi_si_seart_treesitter_TreeSitter_nodeType
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    parserNew
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_usi_si_seart_treesitter_TreeSitter_parserNew
  (JNIEnv *, jclass);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    parserDelete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_parserDelete
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    parserSetLanguage
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_parserSetLanguage
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    parserParseBytes
 * Signature: (J[BI)J
 */
JNIEXPORT jlong JNICALL Java_usi_si_seart_treesitter_TreeSitter_parserParseBytes
  (JNIEnv *, jclass, jlong, jbyteArray, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    parserIncrementalParseBytes
 * Signature: (JJ[BI)J
 */
JNIEXPORT jlong JNICALL Java_usi_si_seart_treesitter_TreeSitter_parserIncrementalParseBytes
  (JNIEnv *, jclass, jlong, jlong, jbyteArray, jint);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    queryDelete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_queryDelete
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    queryNew
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_usi_si_seart_treesitter_TreeSitter_queryNew
  (JNIEnv *, jclass, jlong, jstring);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    queryCursorDelete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_queryCursorDelete
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    queryCursorNew
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_usi_si_seart_treesitter_TreeSitter_queryCursorNew
  (JNIEnv *, jclass);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    queryCursorExec
 * Signature: (JJLusi/si/seart/treesitter/Node;)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_queryCursorExec
  (JNIEnv *, jclass, jlong, jlong, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    queryCursorNextMatch
 * Signature: (J)Lusi/si/seart/treesitter/QueryMatch;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_queryCursorNextMatch
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorNew
 * Signature: (Lusi/si/seart/treesitter/Node;)J
 */
JNIEXPORT jlong JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorNew
  (JNIEnv *, jclass, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorCurrentTreeCursorNode
 * Signature: (J)Lusi/si/seart/treesitter/TreeCursorNode;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorCurrentTreeCursorNode
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorCurrentFieldName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorCurrentFieldName
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorCurrentNode
 * Signature: (J)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorCurrentNode
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorDelete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorDelete
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorGotoFirstChild
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorGotoFirstChild
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorGotoNextSibling
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorGotoNextSibling
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeCursorGotoParent
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeCursorGotoParent
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeDelete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeDelete
  (JNIEnv *, jclass, jlong);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeEdit
 * Signature: (JLusi/si/seart/treesitter/InputEdit;)V
 */
JNIEXPORT void JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeEdit
  (JNIEnv *, jclass, jlong, jobject);

/*
 * Class:     usi_si_seart_treesitter_TreeSitter
 * Method:    treeRootNode
 * Signature: (J)Lusi/si/seart/treesitter/Node;
 */
JNIEXPORT jobject JNICALL Java_usi_si_seart_treesitter_TreeSitter_treeRootNode
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
