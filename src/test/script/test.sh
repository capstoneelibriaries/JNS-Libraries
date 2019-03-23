#!/bin/sh

site="https://e-libraries.store"

username="alice"
email="alice123@email.com"
phone=""
password="password123"

printf "%s\n" "$(curl -X GET ${site}/profile)"

printf "%s\n" \
    "$(curl -d "username=${username}&email=${email}&phone=&password=${password}&confirmPassword=${password}" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -X POST "${site}/login")"
