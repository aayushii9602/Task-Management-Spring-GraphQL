# Task Management GraphQL API

This repository contains a GraphQL API for managing tasks and creators. The API allows you to perform CRUD operations on tasks, manage creators, and interact with creators via email.

## Schema Overview

### Types

1. **Task**
   - Represents a task with the following attributes:
     - `taskId` (Int): Unique identifier for the task.
     - `title` (String): Title of the task.
     - `desc` (String): Description of the task.
     - `creator` (Creator): The creator of the task.
     - `startDate` (String): The start date of the task.
     - `endDate` (String): The end date of the task.
     - `status` (String): The current status of the task.

2. **Creator**
   - Represents a creator with the following attributes:
     - `name` (String): The name of the creator.
     - `email` (String): The email address of the creator.
     - `tasks` ([Task]): List of tasks created by this creator.

### Inputs

1. **TaskInput**
   - Used to create or update tasks with the following attributes:
     - `title` (String): Title of the task.
     - `desc` (String): Description of the task.
     - `creator` (CreatorInput): Information about the creator.
     - `startDate` (String): Start date of the task.
     - `endDate` (String): End date of the task.
     - `status` (String): Status of the task.

2. **CreatorInput**
   - Used to create or update a creator with the following attributes:
     - `name` (String): Name of the creator.
     - `email` (String): Email of the creator.

### Queries

1. **allTasks**
   - Retrieves a list of all tasks.

2. **getTask**
   - Retrieves a specific task by its `taskId`.

3. **getTaskByCreator**
   - Retrieves all tasks created by a specific creator, identified by their email.

4. **getTasksByStatus**
   - Retrieves tasks filtered by a given `status`.

### Mutations

1. **addTask**
   - Adds a new task with the given `TaskInput`.

2. **updateTaskStatus**
   - Updates the status of an existing task by its `taskId`.

3. **deleteTask**
   - Deletes a task by its `taskId`.

4. **sendEmailToCreator**
   - Sends an email to a creator based on their email address.

5. **addCreator**
   - Adds a new creator using the provided `CreatorInput`.

6. **sendMail**
   - Sends an email to a specified recipient with a given `subject` and `text`.
