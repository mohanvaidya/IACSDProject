package com.app.service;

import java.util.List;

import com.app.dto.FeedbackDTO;
import com.app.entities.Feedback;

public interface FeedbackService {
	FeedbackDTO createFeedback(FeedbackDTO feedback);
	
	List<FeedbackDTO> getAllFeedback();

	

	void deletefeedback(Long feedbackId);

	Feedback getFeedbackById(Long feedbackId);

	//String deletefeedback(Long feedbackID);

}
