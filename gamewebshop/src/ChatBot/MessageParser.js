class MessageParser {
    constructor(actionProvider) {
      this.actionProvider = actionProvider;
    }
  
    parse(message) {
      console.log(message);
      const lowercase = message.toLowerCase();
  
      if (lowercase.includes("hello")) {
        this.actionProvider.greet();
      }
      if (lowercase.includes("like") || lowercase.includes("love")) {
        this.actionProvider.handleLike();
      }
      if (lowercase.includes("javascript") || lowercase.includes("js")) {
        this.actionProvider.handleJavascriptQuiz();
      }
      if (lowercase.includes("game") || lowercase.includes("development")) {
        this.actionProvider.handleGameDev();
      }
      if (lowercase.includes("indie")) {
        this.actionProvider.handleIndie();
      }
      if (lowercase.includes("unity") || lowercase.includes("engine")) {
        this.actionProvider.handleEngine();
      }
      if (lowercase.includes("programming") || lowercase.includes("language")) {
        this.actionProvider.handleProgramming();
      }
      else{
        this.actionProvider.handleRandom();
      }
    }
  }
  
  export default MessageParser;