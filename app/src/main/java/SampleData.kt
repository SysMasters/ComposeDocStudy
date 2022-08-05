object SampleData {

    val conversationSample = listOf(
        Message("Colleague", "Test...Test...Test"),
        Message(
            "Colleague",
            "this is a test message for the conversation sample app, please ignore it"
        ),
        Message(
            "Colleague",
            "this is a test message for the conversation sample app, please ignore it"
        ),
        Message(
            "Colleague",
            "this is a test message for the conversation sample app, please ignore it"
        ),
        Message(
            "Colleague",
            "this is a test message for the conversation sample app, please ignore it"
        ),
        Message(
            "Colleague",
            "this is a test message for the conversation sample app, please ignore it"
        ),
        Message(
            "Colleague",
            "this is a test message for the conversation sample app, please ignore it"
        ),
    )

    data class Message(
        var author: String = "",
        var body: String = ""
    )
}