import React from "react";
import Chatbot from "react-chatbot-kit";
import MessageParser from "./MessageParser";
import config from "./config";
import ActionProvider from "./ActionProvider";
import Container from '@mui/material/Container';
function ChatBotComponent(){

    return (
        <Container sx={{ py: 1 }} maxWidth="md">
                        <Chatbot
        config={config}
        actionProvider={ActionProvider}
        messageParser={MessageParser}
        
        />
        </Container>



    ) 


}
export default ChatBotComponent;