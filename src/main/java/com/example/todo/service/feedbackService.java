package com.example.todo.service;


import com.example.todo.dto.FeedbackDto;

import java.util.List;

public interface feedbackService {
    FeedbackDto createFeedback(FeedbackDto feedbackDto);

    FeedbackDto getFeedbackById(Long feedbackId);

    List<FeedbackDto> getAllFeedback();

    FeedbackDto updateFeedback(Long feedbackId, FeedbackDto updatedFeedback);

    void deleteFeedback(Long feedbackId);
}