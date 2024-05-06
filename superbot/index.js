// This line allows us only to import certain things from the discord.js node
const {Client, IntentsBitField} = require('discord.js');

/*
This series of lines is just giving the bot a user account 
and giving it accesss to different features of discord
*/
const superbot = new Client({
    intents:[
        //Servers
        IntentsBitField.Flags.Guilds,
        //Server Members
        IntentsBitField.Flags.GuildMembers,
        //Server Messages
        IntentsBitField.Flags.GuildMessages,
        //Message Contents
        IntentsBitField.Flags.MessageContent,
    ],
})

//Make the bot go online by logging it in
client.login("insert token here");

