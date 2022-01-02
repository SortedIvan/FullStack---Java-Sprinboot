import React, { useState } from "react";
// import FlashCard from "./FlashCard";
import FlashCard from "C:/Users/ivano/OneDrive/Desktop/GIt File Uploads/semester3-individual-assignment/gamewebshop/src/ChatBot/Quiz/FlashCard.jsx";

const Quiz = (props) => {
  console.log(props);
  let [questionIndex, setQuestionIndex] = useState(0);

  const incrementIndex = () => setQuestionIndex((prev) => (prev += 1));

  const currentQuestion = props.questions[questionIndex];

  if (!currentQuestion) {
    return <p>Quiz over.</p>;
  }

  return (
    <FlashCard
    question={currentQuestion.question}
    answer={currentQuestion.answer}
    incrementIndex={incrementIndex}
    
  />
    
  );
};

export default Quiz;