package com.company;

import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        // [2*(2+3)]
        // (1+2*((3+4)
        // LIFO -last in, first out - стек (stack)
        // FIFO - first in, first out -  очередь (queue)
        String brackets = "()[]{}";
        String s = "[(2+3]";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = brackets.indexOf(c);
            System.out.println(index);
            if (index != -1) { // Это скобка
                if (index % 2 == 0) // Это открывающая скобка, т.е. число четное
                    stack.push(c); //  push кладем
                else { // Это закрывающая скобка
                    if (stack.empty()) { // empty смотри пустой ли
                        System.out.println("Ошибка 1");
                        break;
                    }
                    char c2 = stack.peek(); //  peek просто смотрим скобку но не достаем
                    int index2 = brackets.indexOf(c2);
                    if (index-index2==1)
                        stack.pop(); //  pop берем и удаляем
                    else System.out.println("Ошибка 2");
                }
            }
            if (!stack.empty()) System.out.println("Ошибка 3");
        }
    }
}
    /*String brackets = "()[]{}";
    String s = "[(2+3)+2+2]";
       s = s.replaceFirst("2", "1");
                System.out.println(s); */


