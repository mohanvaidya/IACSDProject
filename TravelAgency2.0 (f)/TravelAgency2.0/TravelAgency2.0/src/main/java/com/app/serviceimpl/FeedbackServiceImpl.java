package com.app.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.FeedbackDTO;
import com.app.entities.Booking;
import com.app.entities.Feedback;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.BookingRepo;
import com.app.repository.FeedbackRepo;
import com.app.service.FeedbackService;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public FeedbackDTO createFeedback(FeedbackDTO feedbackDto) {
		Feedback feedback = this.mapper.map(feedbackDto, Feedback.class);
		Feedback savedFeedback = this.feedbackRepo.save(feedback);
		return this.mapper.map(savedFeedback, FeedbackDTO.class);

	}

	@Override
	public List<FeedbackDTO> getAllFeedback() {
		List<Feedback> feedbacks = this.feedbackRepo.findAll();
		List<FeedbackDTO> feedbackDtos = feedbacks.stream()
				.map((feedback) -> this.mapper.map(feedback, FeedbackDTO.class)).collect(Collectors.toList());
		return feedbackDtos;
	}

	@Override
	public void deletefeedback(Long feedbackId) {

		Feedback feedback = feedbackRepo.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("Feedback", "feedbackId", feedbackId));
		this.feedbackRepo.delete(feedback);
	}

	@Override
	public Feedback getFeedbackById(Long feedbackId) {
		return feedbackRepo.findById(feedbackId)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "feedbackId", feedbackId));
	}

}
