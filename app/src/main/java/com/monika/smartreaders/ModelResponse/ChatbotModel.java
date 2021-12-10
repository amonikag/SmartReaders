package com.monika.smartreaders.ModelResponse;

public class ChatbotModel {

        // string to store our message and sender
        private String message;
        private String sender;

        // constructor.
        public ChatbotModel(String message, String sender) {
            this.message = message;
            this.sender = sender;
        }

        // getter and setter methods.
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }


}
