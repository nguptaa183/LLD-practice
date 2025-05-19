package org.example.practice;


import java.net.Inet4Address;
import java.time.temporal.JulianFields;
import java.util.*;

public class Main{
    public static void main(String[] args){
        List<int[]> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(2);
        arr.add(0);
        arr.set(3,10);
        arr.add(2,19);

        List<Integer> fil = arr.stream()
                        .filter(n->n%2==0)
                                .toList();

        System.out.println(fil);

        System.out.println(arr);
        System.out.println(arr.get(arr.size()-1));
        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Map<Integer,Integer> hashset = new HashMap<>();
        System.out.println(hashset.get(1));
        int[] arrr = new int[5];
        for(int i=0;i<5;i++){
            arrr[i] = 5-i;
        }
        char[] carr = new char[5];

        System.out.println(arr.size());
        System.out.println(hashset.size());
        Arrays.sort(arrr);

        System.out.println(Arrays.toString(arrr));
        String s = "dcba";
        System.out.println("==========");
        System.out.println(s.substring(2));

        StringBuilder check = new StringBuilder();
        for(int i=0;i<5;i++){
            check.append(i);
        }
        System.out.println(check);

        System.out.println("==========");
        char[] sarr = s.toCharArray();
        Arrays.sort(sarr);
        System.out.println(sarr);
        Collections.sort(arr);
        System.out.println(arr);
        System.out.println(arrr.length);

        int res  = Arrays.stream(arrr).sum();
        System.out.println(res);

        List<List<Integer>> inp = new ArrayList<>();
        inp.add(Arrays.asList(1,91));
        inp.add(Arrays.asList(1,92));
        inp.add(Arrays.asList(1,60));
        inp.add(Arrays.asList(1,65));
        inp.add(Arrays.asList(1,87));
        inp.add(Arrays.asList(1,100));
        inp.add(Arrays.asList(2,93));
        inp.add(Arrays.asList(2,97));
        inp.add(Arrays.asList(2,77));
        inp.add(Arrays.asList(2,76));
        inp.add(Arrays.asList(2,100));

        List<List<Integer>> out = five(inp);
        System.out.println(out);

//        Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
//        Output: [[1,87],[2,88]]
//        Explanation:
//        The average of the student with id = 1 is 87.
//        The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.

    }

    public static List<List<Integer>> five(List<List<Integer>> inp){
//        [[1, 87], [2, 88]]

        int n=5;
        Map<Integer,PriorityQueue<Integer>> hm = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> i:inp){
            int key = i.get(0);
            int val = i.get(1);

            if(hm.containsKey(key)){
                PriorityQueue<Integer> pqq = hm.get(key);
                pqq.add(val);
                if(pqq.size()>5){
                    pqq.poll();
                }

            }
            else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(val);
                hm.put(key,pq);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry:hm.entrySet()){
            int key = entry.getKey();
            PriorityQueue<Integer> val = entry.getValue();

            int sum=0;
            while(val.size()!=0){
                sum+=val.poll();
            }
            res.add(Arrays.asList(key,sum/5));

        }

        return res;

    }
}

