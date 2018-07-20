package com.perpule.feedback;

import com.perpule.singletons.DBManager;
import com.perpule.utils.RandomAndHashStringUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class FeedbackDAO {
  public FeedbackModel giveFeedback(FeedbackModel feedbackModel)
      throws SQLException, NoSuchAlgorithmException {
      String id = feedbackModel.getId();
      String technicalKnowledge = feedbackModel.getTechnicalKnowledge();
      String communicationSkill = feedbackModel.getCommunicationSkill();
      String conveyIdeas = feedbackModel.getConveyIdeas();
      String trustFactor = feedbackModel.getTrustFactor();
      String satisfactionFactor = feedbackModel.getSatisfactionFactor();
      String sangeethaInitiative = feedbackModel.getSangeethaInitiative();
    String sqlQuery =
        "INSERT INTO feedback (id, technicalKnowledge , communicationSkill, conveyIdeas, trustFactor, satisfactionFactor, sangeethaInitiative) VALUES ( '"
            + id
            + "' , '"
            + technicalKnowledge
            + "' , '"
            + communicationSkill
            + "' , '"
            + conveyIdeas
            + "' , '"
            + trustFactor
            + "' , '"
            + satisfactionFactor
            + "' , '"
            + sangeethaInitiative
            + "')";
    if (DBManager.doQuery(sqlQuery)) {
      return feedbackModel;
    } else {
      throw new Error("doQuery function not working!");
    }
  }
}
