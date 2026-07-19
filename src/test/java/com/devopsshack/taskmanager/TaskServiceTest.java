package com.devopsshack.taskmanager;

import com.devopsshack.taskmanager.model.Task;
import com.devopsshack.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void shouldCreateTaskWithGeneratedId() {
        Task task = new Task(null, "Apprendre GitLab CI/CD", false);

        Task created = taskService.create(task);

        assertThat(created.getId()).isNotNull();
        assertThat(taskService.findById(created.getId()).getTitle())
                .isEqualTo("Apprendre GitLab CI/CD");
    }

    @Test
    void shouldReturnAllCreatedTasks() {
        taskService.create(new Task(null, "Tache 1", false));
        taskService.create(new Task(null, "Tache 2", true));

        assertThat(taskService.findAll()).hasSize(2);
    }

    @Test
    void shouldDeleteExistingTask() {
        Task created = taskService.create(new Task(null, "A supprimer", false));

        boolean deleted = taskService.delete(created.getId());

        assertThat(deleted).isTrue();
        assertThat(taskService.findById(created.getId())).isNull();
    }

    @Test
    void shouldReturnFalseWhenDeletingUnknownTask() {
        assertThat(taskService.delete(999L)).isFalse();
    }
}
