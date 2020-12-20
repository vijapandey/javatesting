package com.javatesting.collection;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'simpleCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING encrypted
     *  2. INTEGER k
     */

    public static String simpleCipher(String encrypted, int k) {
        System.out.println("encrypted :" + encrypted);
        String returnDecrypted = "";
        if(null != encrypted && !encrypted.isEmpty() && k >0){
            
            char [] charArray = encrypted.toCharArray();
            char [] tempCharArray = new char[charArray.length];
            System.out.println(charArray);
            int i = 0;
             for (char char1 : charArray) {
                int numericValue =  char1;
         
                    //65 <> 90
                if (numericValue > 64 && numericValue < 91){
                    if ((numericValue-k)<64) {
                    	int less = numericValue - k;
                    	//System.out.println("LESS :" + less);
                        numericValue = 90 - (65 - ((less)+1));
                        
                    } else {
                    	numericValue = numericValue -k ;
                    }
                       tempCharArray[i++] = (char) numericValue;  
                } else {
                	tempCharArray[i++] = (char) numericValue;
                    System.out.println("NonConvert : " + numericValue);
                }
            }
            returnDecrypted = String.valueOf(tempCharArray);
            return returnDecrypted;
        }


        return returnDecrypted;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String enc = "QMOPODOVNRDYLUACVRAYGGWNPNZIJDIFYERVJAOALCGXOVLDQFZAORAHDIGYOJKNVIAZTPCMXLVOVAFHJPHVSHYFIQQTQBXJJMQNGQJHWKCEXECMDKMZAKBZRKJWQDYUXDVOOSSJOATRYXMBWXBWEXNAGMAYGZYFNZPQFTOBTAOTUAYXMWVZLLKUJIDHUKZWZCLTGQNGGUFTUAHALWVJWQNCKSIZGZAJKHYJUJLKSESZAFZJMDTSBYLDHYLCGKYNGVMHNEQYJDUGOFKLITXAOYKFOQKZSZNJYARKUPRERIVHUBPEHXMOYDAKKLBDNFHFXAMOTUBELZVBOZJARAEFMLOTFTNQRJOLVUAMAHNDEKFDSQCFVMQBOCBOMJXRQSFSKEVFXPHCQOQKBBOMCYURWLRNHRHCTNTZLYLVWULBDKCDPPGYKICHJTPUKFNLXFCEVKJEZQSMEYCANJLBESSRFAZDPRCOMDPJIMSFBUSLKSYVEERGCGMONCTCSVYPOLPLCGSQYFKILRIXODIWQCYREIWKRPIUIASFKJEXPFTZNQIBLSRJUYFSKNDAPWJEFUCDQCIUEHVFNDGHRXXNMVZLJXIOYUNDVPNDABSBNWOEYOMRJDCQCRXVYAHERMUDCCMUEAHEBYVSAKXWSEQZDUYFEZUJAFFDRSQFSEQSDFCGDENMRFWFNDIJTEPXHNVEDFBAGZRXKPRTGBOUKFXIWHFZFKSNAWGCUBSPXSIUYTQRWMVXFSVZLOTLFWIMLIYGNFDDESWMXUVHNQVJZGKPDZFJMCJCMSAASKEXTLSJRGGTYCGCQFPOQOMROUHJKNTQRYHJIFCXBYWHFUTFZMJCDLIVNUXMRDFGHKQLQZAEEAZKOOMVPYSJWNCYQYABUTSITEZURQHBUWABEXRCUIWAFNFVCASMRMBQNUPRUSKHSMEICAQQESYYVOPEPMVDOSIBR";
    	//VGXGPU =>JULUDI
        String result = Result.simpleCipher("#TEST T'", 12);
        System.out.println(result);
    }
}
