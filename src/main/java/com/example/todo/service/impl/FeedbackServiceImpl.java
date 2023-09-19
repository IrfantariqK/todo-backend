package com.example.todo.service.impl;

import com.example.todo.dto.FeedbackDto;
import com.example.todo.entity.Feedback;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.mapper.FeedbackMapper;
import com.example.todo.repository.FeedbackRepository;

import com.example.todo.service.feedbackService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements feedbackService {

    private final FeedbackRepository feedbackRepository;

    @Override
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = FeedbackMapper.mapToFeedback(feedbackDto);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return FeedbackMapper.mapToFeedbackDto(savedFeedback);
    }

    @Override
    public FeedbackDto getFeedbackById(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Feedback is not exists with given id : " + feedbackId));

        return FeedbackMapper.mapToFeedbackDto(feedback);
    }



    @Override
    public List<FeedbackDto> getAllFeedback() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream().map((feedback) -> FeedbackMapper.mapToFeedbackDto(feedback))
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto updateFeedback(Long feedbackId, FeedbackDto updatedFeedback) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(
                () -> new ResourceNotFoundException("Feedback is not exists with given id: " + feedbackId)
        );

        feedback.setName(updatedFeedback.getName());
        feedback.setTitle(updatedFeedback.getTitle());
        feedback.setImage(updatedFeedback.getImage());
        feedback.setFeedback(updatedFeedback.getFeedback());
        feedback.setAge(updatedFeedback.getAge());
        feedback.setEmail(updatedFeedback.getEmail());

        Feedback updatedFeedbackObj = feedbackRepository.save(feedback);

        return FeedbackMapper.mapToFeedbackDto(updatedFeedbackObj);
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(
                () -> new ResourceNotFoundException("Feedback is not exists with given id: " + feedbackId)
        );

        feedbackRepository.deleteById(feedbackId);
    }
}
