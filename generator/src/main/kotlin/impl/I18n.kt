package impl

object BuildParameters {
    private var _target_language = ThreadLocal<String>().apply { set("de") }

    var language: String
        get() = _target_language.get() ?: "de"
        set(name) {
            _target_language.set(name)
        }

    val language_suffix: String
        get() = if (language == "de") "" else "-$language"
}

infix fun String.en(en_text: String): String {
    return if (BuildParameters.language == "en") en_text else this
}
