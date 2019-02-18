/*
package com.company;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Lab2
{
    public static class MediaServer
    {
        private ServerSocket socket;
        private Thread listener;


        MediaServer() throws IOException
        {
            System.out.println("Init Server");
            socket = new ServerSocket();
        }

        public void loadMP3(File mp3File, String fileName)
        {
            System.out.println("Loading mp3: " + fileName + " ...");
        }

        public void asyncStart(String host, int port) throws IOException
        {
            System.out.println("Starting server...");
            socket.bind(new InetSocketAddress(host, port));
            listen();
            System.out.println("Server started");
        }

        public void stop() throws IOException
        {
            if (listener != null)
                listener.stop();        // Костыль, потом добавить стоп сигнал
            socket.close();
            System.out.println("Server stopped");
        }

        private void listen()
        {
            listener = new Thread(() ->
            {
                while (true)
                {
                    try
                    {
                        socket.accept();
                    }
                    catch (IOException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                        break;
                    }
                }
            });
            listener.start();
        }

    }


    public static class MediaClient
    {
        public void connectIntoServer(String host, int port)
        {
            System.out.println("Connecting to server...");
        }

        public void playMP3(String fileName) throws LineUnavailableException, IOException, UnsupportedAudioFileException
        {
            Media media = new Media("file:///Movies/test.mp3"); //replace /Movies/test.mp3 with your file
            MediaPlayer player = new MediaPlayer(media);
            player.play();

            System.out.println("Playing mp3...");
        }
    }

    public static MediaServer initServer() throws IOException
    {
        return new MediaServer();
    }


    public static MediaClient initClient()
    {
        return new MediaClient();
    }
}
*/