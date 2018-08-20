package cn.dubby.rxjava.demo.helloworld;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HelloWorld {

    public static void helloV1(String... names) {
        Observable.fromArray(names).subscribe(new Consumer<String>() {

            public void accept(String s) throws Exception {
                System.out.println("Hello " + s + "!");
            }

        });
    }

    public static void helloV2(String... names) {
        Observable.fromArray(names).subscribe(new Observer<String>() {

            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            public void onNext(String s) {
                System.out.println("onNext: Hello " + s + "!");
            }

            public void onError(Throwable e) {
                System.out.println("onError");
            }

            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    public static void main(String[] args) {
        helloV1("dubby", "杨正", "道玄");
        helloV2("dubby", "杨正", "道玄");
    }

}
