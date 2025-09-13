package com.example.todo_app.service;

import com.example.todo_app.dto.TodoCreateRequest;
import com.example.todo_app.dto.TodoUpdateRequest;
import com.example.todo_app.model.Todo;
import com.example.todo_app.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


/* https://github.com/Scroll-master/todo-app/blob/main/src/test/java/com/example/todo_app/service/TodoServiceTest.java */

class TodoServiceTest {

    // Constants for testing
    private static final UUID TEST_ID = UUID.randomUUID();
    private static final String TEST_TITLE = "Test Title";
    private static final String TEST_DESCRIPTION = "Test Description";
    private static final String NEW_TITLE = "New Title";
    private static final String NEW_DESCRIPTION = "New Description";


    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllTodos() {

        // Call the service method
        List<Todo> todos = todoService.getAll();

        // Assertions
        assertEquals(2, todos.size()); // Check the size of the list
        // Check the first todo
        assertEquals(TEST_TITLE, todos.get(0).getTitle());
        assertEquals(TEST_DESCRIPTION, todos.get(0).getDescription());
        assertFalse(todos.get(0).isCompleted());
        // Check the second todo
        assertEquals(NEW_TITLE, todos.get(1).getTitle());
        assertEquals(NEW_DESCRIPTION, todos.get(1).getDescription());
        assertTrue(todos.get(1).isCompleted());
    }



    @Test
    public void testUpdateTodo() {
        // Create an existing Todo object
        Todo existingTodo = Todo.builder()
                .id(TEST_ID) // Use constant for ID
                .title(TEST_TITLE) // Use constant for title
                .description(TEST_DESCRIPTION) // Use constant for description
                .completed(false) // Default status
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        // Create a TodoUpdateRequest object
        TodoUpdateRequest request = new TodoUpdateRequest();
        request.setTitle(NEW_TITLE); // Use constant for new title
        request.setDescription(NEW_DESCRIPTION); // Use constant for new description
        request.setCompleted(true); // Mark as completed

        // Mock repository responses
        when(todoRepository.findById(TEST_ID)).thenReturn(Optional.of(existingTodo));
        when(todoRepository.save(any(Todo.class))).thenReturn(existingTodo);

        // Call the update method
        Todo updatedTodo = todoService.update(TEST_ID, request);

        // Assertions
        assertEquals(NEW_TITLE, updatedTodo.getTitle()); // Title should be updated
        assertEquals(NEW_DESCRIPTION, updatedTodo.getDescription()); // Description should be updated
        assertTrue(updatedTodo.isCompleted()); // Status should be updated
        assertNotNull(updatedTodo.getUpdatedAt()); // Update date should not be null
    }



}