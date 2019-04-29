/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trianglesum_highest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.util.Arrays.stream;

/**
 *
 * @author bnayak
 */
public class TriangleSum_Highest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int[][] data = Files.lines(Paths.get("D://TriangleLive.txt"))
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
 
          for (int r = data.length - 1; r > 0; r--)
            for (int c = 0; c < data[r].length - 1; c++)
                if(data[r][c] % 2 == 0 ){
                    data[r - 1][c] += Math.max(data[r][c], data[r][c + 1]);
                }else{
                    data[r - 1][c] += Math.max(data[r][c], data[r][c + 1]);
                }
                
        System.out.println(data[0][0]);
    }
    
}
