
// ---------------------------moved from main.js----------------------------
'use strict';

var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var connectingElement = document.querySelector('.connecting');
var chatHistory = document.querySelector('.chat-history');
var chatMessageCounter = document.querySelector('.chat-message-counter');

var stompClient = null;
var username = null;
var email = null;
var phone = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function defaultSettings() {
    messageForm.hidden = "hidden";
    chatHistory.hidden = "hidden";
    chatMessageCounter.hidden = "hidden";
    connectingElement.hidden = "hidden";
}

function onConnectedSettings() {
    messageForm.removeAttribute("hidden");
    chatHistory.removeAttribute("hidden");
    chatMessageCounter.removeAttribute("hidden");
    connectingElement.hidden = "hidden";
    usernameForm.hidden = "hidden";
}

function connect(event) {
    username = document.querySelector('#name').value.trim();
    email = document.querySelector('#email').value.trim();
    phone = document.querySelector('#phone').value.trim();

    if(username && email && phone) {
        connectingElement.removeAttribute("hidden");

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    var chatMessage = {
        sender: username,
        userEmail: email,
        userPhone: phone,
        messageType: 'JOIN'
    };

    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify(chatMessage)
    );

    onConnectedSettings();
}

function onError(error) {
    connectingElement.textContent = 'Something going wrong! Please try again';
    connectingElement.style.color = 'red';
}

function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageContent,
            messageType: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('div');
    messageElement.classList.add('chat-message');
    messageElement.classList.add('clearfix');

    var avatarElement = document.createElement('i');
    var avatarText = document.createTextNode(message.sender[0]);
    avatarElement.appendChild(avatarText);
    avatarElement.style['background-color'] = getAvatarColor(message.sender);
    messageElement.appendChild(avatarElement);

    var chatMessageContentElement = document.createElement("div");
    chatMessageContentElement.classList.add("chat-message-content");
    chatMessageContentElement.classList.add("clearfix");

    var chatTimeElement = document.createElement("span");
    chatTimeElement.classList.add("chat-time");
    var chatTimeText = document.createTextNode("15:37"); // time
    chatTimeElement.appendChild(chatTimeText);
    chatMessageContentElement.appendChild(chatTimeElement);

    var messageSenderElement = document.createElement("h5");
    var usernameText = document.createTextNode(message.sender);
    messageSenderElement.appendChild(usernameText);
    chatMessageContentElement.appendChild(messageSenderElement);

    if(message.messageType === 'JOIN') {
        message.content = message.sender + ' joined!';
    } else if (message.messageType === 'LEAVE') {
        message.content = message.sender + ' left!';
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);
    chatMessageContentElement.appendChild(textElement);

    messageElement.appendChild(chatMessageContentElement);

    chatHistory.appendChild(messageElement);
    chatHistory.scrollTop = chatHistory.scrollHeight;
}

function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

defaultSettings();
usernameForm.addEventListener('submit', connect, true);
messageForm.addEventListener('submit', sendMessage, true);

// ---------------------------moved from main.js----------------------------


(function () {
    //
    $('#live-chat header').on('click', function () {
        $('.chat').slideToggle(300, 'swing');
        $('.chat-message-counter').fadeToggle(300, 'swing');
    });
    //
    $('.chat-close').on('click', function (e) {
        e.preventDefault();
        $('#live-chat').fadeOut(300);
    });
}) ();

