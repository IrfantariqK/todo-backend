package com.example.todo.Controller;

import com.example.todo.dto.FeedbackDto;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private com.example.todo.service.feedbackService feedbackService;

    // Build Add Feedback REST API
    @PostMapping
    public ResponseEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto){
        FeedbackDto savedFeedback = feedbackService.createFeedback(feedbackDto);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    // Build Get Feedback REST API
    @GetMapping("{id}")
    public ResponseEntity<FeedbackDto> getFeedbackById(@PathVariable("id") Long feedbackId){
        FeedbackDto feedbackDto = feedbackService.getFeedbackById(feedbackId);
        return ResponseEntity.ok(feedbackDto);
    }

    // Build Get All Feedback REST API
    @GetMapping
    public ResponseEntity<List<FeedbackDto>> getAllFeedback(){
        List<FeedbackDto> feedback = feedbackService.getAllFeedback();
        return ResponseEntity.ok(feedback);
    }

    // Build Update Feedback REST API
    @PutMapping("{id}")
    public ResponseEntity<FeedbackDto> updateFeedback(@PathVariable("id") Long feedbackId,
                                                      @RequestBody FeedbackDto updatedFeedback){
        FeedbackDto feedbackDto = feedbackService.updateFeedback(feedbackId, updatedFeedback);
        return ResponseEntity.ok(feedbackDto);
    }

    // Build Delete Feedback REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable("id") Long feedbackId){
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}