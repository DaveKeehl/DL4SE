package usi.si.seart.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usi.si.seart.dto.ConfigurationDto;
import usi.si.seart.model.Configuration;
import usi.si.seart.model.task.Task;
import usi.si.seart.model.user.User;
import usi.si.seart.security.annotation.AdminRestController;
import usi.si.seart.service.ConfigurationService;
import usi.si.seart.service.TaskService;
import usi.si.seart.service.UserService;

import javax.validation.Valid;
import java.util.List;

@AdminRestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AdminController {

    UserService userService;
    TaskService taskService;
    ConversionService conversionService;
    ConfigurationService configurationService;

    @GetMapping("/users")
    public ResponseEntity<?> listUsers(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "registered") String column
    ) {
        Integer pageSize = configurationService.get("page_size", Integer.class);
        List<User> users = userService.getAll(page, pageSize, column);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> listTasks(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "submitted") String column
    ) {
        Integer pageSize = configurationService.get("page_size", Integer.class);
        List<Task> tasks = taskService.getAll(page, pageSize, column);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/{id}/enable")
    public ResponseEntity<?> enableUser(@PathVariable Long id) {
        User user = userService.getWithId(id);
        user.setEnabled(true);
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/disable")
    public ResponseEntity<?> disableUser(@PathVariable Long id) {
        User user = userService.getWithId(id);
        user.setEnabled(false);
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/configuration")
    public ResponseEntity<?> updateConfiguration(@Valid @RequestBody ConfigurationDto configurationDto) {
        Configuration configuration = conversionService.convert(configurationDto, Configuration.class);
        boolean exists = configurationService.exists(configuration);
        if (!exists) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        configuration = configurationService.modify(configuration);
        return ResponseEntity.ok(configuration);
    }
}
