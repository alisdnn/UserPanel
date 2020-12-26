package com.alisdnn.userpanel.presentation.user.login

import java.util.regex.Matcher
import java.util.regex.Pattern


val VALID_EMAIL_ADDRESS_REGEX: Pattern =
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

val VALID_PASSWORD_REGEX = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{3,}\$")


fun isValidEmail(email: String): Boolean {
    val matcher: Matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email)
    return matcher.find()}

fun isValidPassword(password: String): Boolean {
    return VALID_PASSWORD_REGEX.containsMatchIn(password)
}