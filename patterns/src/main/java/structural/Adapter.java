package structural;

/***
 * Позволяет интегрировать классы с несовместимыми интерфейсами без изменения их исходного кода.
 *
 */
public class Adapter {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        Radio radio = new Radio();
        EuroSocket euroSocket = new SocketAdapter(americanSocket);
        radio.listenMusic(euroSocket);
    }
}

class SocketAdapter implements EuroSocket{

    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
          americanSocket.getPower();
    }
}

interface EuroSocket{
    void getPower();
}

interface AmericanSocket{
    void getPower();
}

class SimpleAmericanSocket implements AmericanSocket {

    @Override
    public void getPower() {
        System.out.println("get 110 volt");
    }
}

class Radio {
    public void listenMusic(EuroSocket euroSocket){
        euroSocket.getPower();
    }
}
