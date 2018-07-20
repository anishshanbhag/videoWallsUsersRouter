package com.perpule.feedback;

public class FeedbackModel {
  private String id;
  private String technicalKnowledge;
  private String communicationSkill;
  private String conveyIdeas;
  private String trustFactor;
  private String satisfactionFactor;
  private String sangeethaInitiative;

  public FeedbackModel() {}

  public FeedbackModel(String id ,String technicalKnowledge, String communicationSkill, String conveyIdeas,String trustFactor,String satisfactionFactor,String sangeethaInitiative) {
    this.id = id;
    this.technicalKnowledge = technicalKnowledge;
    this.communicationSkill = communicationSkill;
    this.conveyIdeas = conveyIdeas;
    this.trustFactor = trustFactor;
    this.satisfactionFactor = satisfactionFactor;
    this.sangeethaInitiative = sangeethaInitiative;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getTechnicalKnowledge() {
    return technicalKnowledge;
  }

  public void setTechnicalKnowledge(String technicalKnowledge) {
    this.technicalKnowledge = technicalKnowledge;
  }

  public String getCommunicationSkill() {
    return communicationSkill;
  }

  public void setCommunicationSkill(String communicationSkill) {
    this.communicationSkill = communicationSkill;
  }

  public String getConveyIdeas() {
    return conveyIdeas;
  }

  public void setConveyIdeas(String conveyIdeas) {
    this.conveyIdeas = conveyIdeas;
  }

  public String getTrustFactor(){
    return trustFactor;
  }

  public void setTrustFactor(String trustFactor){
    this.trustFactor = trustFactor;
  }

  public String getSatisfactionFactor(){
    return satisfactionFactor;
  }

  public void setSatisfactionFactor(String satisfactionFactor){
    this.satisfactionFactor = satisfactionFactor;
  }

  public String getSangeethaInitiative(){
    return sangeethaInitiative;
  }

  public void setSangeethaInitiative(String sangeethaInitiative){
    this.sangeethaInitiative = sangeethaInitiative;
  }
}
