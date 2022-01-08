import GameService from "../services/GameService";

class ActionProvider {
    constructor(createChatBotMessage, setStateFunc) {
      this.createChatBotMessage = createChatBotMessage;
      this.setState = setStateFunc;
    }


    greet = () => {
      const message = this.createChatBotMessage("Greetings, Game Dev!");
      this.addMessageToState(message);
    };
    handleGameDev = () => {
      const message = this.createChatBotMessage("This website is specifically designed for people who specialize in indie game development!");
      this.addMessageToState(message);
    };
    handleIndie = () => {
      const message = this.createChatBotMessage("An indie game, short for independent video game, is a video game typically created by individuals or smaller development teams without the financial and technical support of a large game publisher, in contrast to most AAA (triple-A) games. ");
      this.addMessageToState(message);
    };
    handleProgramming = () => {
      const message = this.createChatBotMessage("The best programming languages for game development are C#, C++ and C. They are widely used across engines/game frameworks and well supported!");
      this.addMessageToState(message);
    };
    handleLike = () => {
      const message = this.createChatBotMessage("I can't express emotion, but I like you too!");
      this.addMessageToState(message);
    };
    handleEngine = () => {
      const message = this.createChatBotMessage("Game engines are tools used by developers to create games. Example of those are Unity, Godot, Unreal Engine, etc.");
      this.addMessageToState(message);
    };
    handleRandom = () => {
      let randomMessageNr = GameService.getRandomNumber();
      console.log(randomMessageNr);
      let randomMessage = "";

      if(randomMessageNr === 1){
        randomMessage = "Beep boop, I don't understand!"
      }
      if(randomMessageNr === 2){
        randomMessage = "Slow down partner, I don't get it!"
      }
      if(randomMessageNr === 3){
        randomMessage = "I don't understand, could you repeat it?"
      }
      if(randomMessageNr === 4){
        randomMessage = "42. That's always the answer"
      }
      if(randomMessageNr === 5){
        randomMessage = "I am a chatbot, not a wizard! Please be more specific."
      }
      if(randomMessageNr === 6){
        randomMessage = "Could you elaborate?"
      }
      if(randomMessageNr === 7){
        randomMessage = "I missed my morning coffee, could you repeat?"
      }
      if(randomMessageNr === 8){
        randomMessage = "My gears aren't set correctly today, can you repeat?"
      }
      if(randomMessageNr === 9){
        randomMessage = "I don't get your question."
      }
      if(randomMessageNr === 10){
        randomMessage = "I am sorry, I didnt understand your question."
      }
      let message = this.createChatBotMessage(randomMessage);
      this.addMessageToState(message);
    };
    handleJavascriptQuiz = () => {
      const message = this.createChatBotMessage(
        "Fantastic. Here is your quiz. Good luck!",
        {
          widget: "javascriptQuiz",
        }
      );
  
      this.addMessageToState(message);
    };

  
  
    addMessageToState = (message) => {
      this.setState((prevState) => ({
        ...prevState,
        messages: [...prevState.messages, message],
      }));
    };
  }
  
  export default ActionProvider;