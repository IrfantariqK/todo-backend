package com.example.todo.mapper;

import com.example.todo.dto.FeedbackDto;
import com.example.todo.entity.Feedback;

public class FeedbackMapper {
    public static FeedbackDto mapToFeedbackDto(Feedback feedback) {
        return new FeedbackDto(
                feedback.getId(),
                feedback.getName(),
                feedback.getTitle(),
                feedback.getImage(),
                feedback.getAge(),  // Corrected mapping for Age
                feedback.getEmail(), // Corrected mapping for Email
                feedback.getFeedback()
        );
    }

    public static Feedback mapToFeedback(FeedbackDto feedbackDto) {
        return new Feedback(
                feedbackDto.getId(),
                feedbackDto.getName(),
                feedbackDto.getTitle(),
                feedbackDto.getImage(),
                feedbackDto.getAge(),  // Corrected mapping for Age
                feedbackDto.getEmail(), // Corrected mapping for Email
                feedbackDto.getFeedback()
        );
    }
}
