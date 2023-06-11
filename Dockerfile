FROM openjdk:11

WORKDIR /C:\Users\Harris\AndroidStudioProjects\TinyToes2

COPY . /C:\Users\Harris\AndroidStudioProjects\TinyToes2

RUN ./gradlew assembleDebug

EXPOSE 8080

CMD ["./gradlew", "run"]

