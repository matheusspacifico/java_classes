package SocialMedia_Challenge;

public class Main {
    public static void main(String[] args) {
        // Criando usuários
        UserAccount user1 = new UserAccount("user1@example.com", "User1");
        UserAccount user2 = new UserAccount("user2@example.com", "User2");
        UserAccount user3 = new UserAccount("user3@example.com", "User3");

        // Adicionando seguidores (User2 e User3 seguem User1)
        user1.acceptFollower(user2);
        user1.acceptFollower(user3);

        // User1 publica alguns posts
        System.out.println("\nUser1 publicando posts:");
        user1.publish("Hello, this is my first post!");
        user1.publish("Enjoying the weather today.");
        user1.publish("Just had a great lunch!");

        // Mostrar timeline dos seguidores após os posts de User1
        System.out.println("\nTimeline de User2 após User1 publicar posts:");
        System.out.println(user2.showTimeline());

        System.out.println("Timeline de User3 após User1 publicar posts:");
        System.out.println(user3.showTimeline());

        // Interagindo com os posts (User2 e User3 aplaudem e vaiam posts)
        System.out.println("\nUser2 aplaudindo o primeiro post e vaiando o segundo:");
        user2.clapPost(0);  // Clap no primeiro post
        user2.booPost(1);   // Boo no segundo post

        System.out.println("\nUser3 aplaudindo o terceiro post:");
        user3.clapPost(2);  // Clap no terceiro post

        // Mostrando timelines novamente para ver as interações
        System.out.println("\nTimeline de User2 atualizada:");
        System.out.println(user2.showTimeline());

        System.out.println("Timeline de User3 atualizada:");
        System.out.println(user3.showTimeline());

        // Mostrando os posts de User1
        System.out.println("\nPosts de User1:");
        System.out.println(user1.showMyPosts());

        // Excluir um post de User1
        System.out.println("\nUser1 deletando o segundo post:");
        user1.delete(1);  // Deletando o segundo post (índice 1)

        // Mostrar os posts de User1 após deletar
        System.out.println("\nPosts de User1 após deletar:");
        System.out.println(user1.showMyPosts());

        // User1 bloqueia User3
        System.out.println("\nUser1 bloqueando User3:");
        user1.blockFollower(user3);

        // Mostrar amigos de User1 após bloquear User3
        System.out.println("\nAmigos de User1 após bloquear User3:");
        System.out.println(user1.showMyFriends());
    }
}
