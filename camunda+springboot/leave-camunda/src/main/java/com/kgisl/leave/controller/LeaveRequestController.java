package com.kgisl.leave.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.leave.model.LeaveRequest;

@RestController
@RequestMapping("/leave")
public class LeaveRequestController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    
    @GetMapping("/checkBalance")
    public String checkLeaveBalance() {
               return "Leave balance checked.";
    }

    @PostMapping("/start")        //new leave request process
    public String startLeaveProcess(@RequestBody LeaveRequest leaveRequest) {
        // Start a new process instance
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave-management");

        // Set process variables
        runtimeService.setVariable(processInstance.getId(), "leaveRequest", leaveRequest);

        // Return the process instance ID
        return "Leave process started with ID: " + processInstance.getId();
    }

   
    @PostMapping("/completeTask/{taskId}")          //complete a user task (manager approval)
    public ResponseEntity<String> completeUserTask(@PathVariable String taskId,@RequestParam("approve") boolean approve) {
    	try {
            // Verify if the task exists
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            
            if (task == null) {
                return ResponseEntity.badRequest().body("Task with ID " + taskId + " not found.");
            }

            // Complete the user task using the Camunda TaskService
            taskService.complete(taskId);

            if (approve) {
                return ResponseEntity.ok("Task " + taskId + " approved.");
            } else {
                return ResponseEntity.ok("Task " + taskId + " disapproved.");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error completing the task: " + e.getMessage());
        }
    }
}
