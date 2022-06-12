package hello.core.singleton;

public class SingtonService
{
    private static final SingtonService instance = new SingtonService();

    public static SingtonService getInstance()
    {
        return instance;
    }

    private SingtonService() {}

    public void logic()
    {
        System.out.println("싱글톤 객체 로직 호출");
    }
}