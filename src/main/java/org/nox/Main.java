package org.nox;

/*Первая итерация цикла for:

* Создается объект MyException внутри блока try.
* В статическом блоке init() снова создается объект MyException, что вызывает исключение.
* Это исключение поймано в блоке catch. Выводится сообщение "e = " с информацией о перехваченном исключении.
* Затем проверяется, является ли причина исключения объектом MyException,
* и выводится сообщение "e instanceof MyException, s = Hello" с вызовом метода ex.get(), который возвращает "Hello".


* Вторая итерация цикла for:

*Все шаги повторяются точно так же, как и в первой итерации, и будет выведено то же самое сообщение.*/

public class Main {
  public static void main(String[] args) {

    for (int i = 0; i < 2; i++) {
      try {
        new MyException();
      } catch (Throwable e) {
        System.out.println("e = " + e);
        // Проверка, является ли причина исключения объектом типа MyException.
        if (e.getCause() instanceof MyException) {
          MyException ex = (MyException) e.getCause(); // Преобразование причины в объект MyException.
          // Вывод о том, что причина является объектом MyException и сообщение из этой причины с
          // помощью ex.get().
          System.out.println("e instanceof " + MyException.class.getName() + ", s = " + ex.get());
        }
      }
    }
  }
}
