package com.devopsshack.taskmanager.service;

import com.devopsshack.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<Task> findAll() {
        return List.copyOf(tasks.values());
    }

    public Task findById(Long id) {
        return tasks.get(id);
    }

    public Task create(Task task) {
        long id = counter.incrementAndGet();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    public boolean delete(Long id) {
        return tasks.remove(id) != null;
    }
    public Task update(Long id, Task updatedTask) {
    Task existingTask = tasks.get(id);

    if (existingTask == null) {
        return null;
    }

    existingTask.setTitle(updatedTask.getTitle());
    existingTask.setDone(updatedTask.isDone());

    return existingTask;
}
}
