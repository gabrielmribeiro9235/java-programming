package br.com.gabriel.claude.exercises.polymorphism.client;

import java.util.StringJoiner;

public class FakeClientRepository implements Repository<String, Client> {
    private Client[] clients;
    private int numberOfClients;

    public FakeClientRepository() {
        clients = new Client[10];
    }

    private void increaseArraySize() {
        Client[] copy = clients.clone();

        clients = new Client[numberOfClients * 2];

        for (int i = 0; i < numberOfClients; i++) {
            clients[i] = copy[i];
        }
    }

    @Override
    public void saveEntity(Client entity) {
        if (entity == null) return;

        if (numberOfClients == clients.length) increaseArraySize();

        clients[numberOfClients++] = entity;
    }

    @Override
    public Client findById(String id) {
        if (id == null) return null;

        for (int i = 0; i < numberOfClients; i++) {
            if (clients[i].getId().equals(id)) return clients[i];
        }

        return null;
    }

    public String showAllClients() {
        StringJoiner joiner = new StringJoiner("\n------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < numberOfClients; i++) {
            joiner.add("Client " + (i + 1) + "\n" + clients[i].toString());
        }

        return joiner.toString();
    }
}
