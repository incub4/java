package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException
    {
        // Первая лаба
        int[] arr = {1,5,2,3,5,6,3,2,5,7};                  // Тестовые данные
        Lab1.parallelSort(arr);                             // Сортировка
        Arrays.stream(arr).forEach(System.out::println);    // Вывод результата


        // Вторая лаба, прототип
        /*
            Разработать приложение воспроизводящее звуковой файл с сервера, использовать протокол TCP/IP
             и сжатие данных (Журавлев)
         */

       /* var mediaServer = Lab2.initServer();
        mediaServer.loadMP3(new File("some.mp3"), "some.mp3");
        mediaServer.asyncStart("127.0.0.1", 8080);                  // Асинхронно запускаем сервер


        var mediaClient = Lab2.initClient();
        mediaClient.connectIntoServer("127.0.0.1", 8080);           // Подсоединяемся к серверу. Клиент синхронный.
        mediaClient.playMP3("/Users/soloduev/IdeaProjects/Labs/sound.WAV");

        mediaServer.stop();
        */
    }
}
