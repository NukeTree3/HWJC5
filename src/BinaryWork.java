import java.util.Arrays;

public class BinaryWork {
    public byte[] numToByteArray(int box) {

        /*
        00 - 0
        01 - 1
        10 - 2
        11 - 3
        */

        String input = "" + box;
        StringBuilder output = new StringBuilder();

        if(input.length() < 9){
            input = "0".repeat(9 - input.length()) + input;
        }

        for(char c : input.toCharArray()){
            switch(c){
                case '0': output.append("00"); break;
                case '1': output.append("01"); break;
                case '2': output.append("10"); break;
                case '3': output.append("11"); break;
            }
        }

        byte[] bytes = new byte[3];
        bytes[0] = Byte.parseByte(output.substring(0, 6),2);
        bytes[1] = Byte.parseByte(output.substring(6, 12),2);
        bytes[2] = Byte.parseByte(output.substring(12, 18),2);

        return bytes;
    }

    public String byteArrayToString(byte[] bytes) {
        StringBuilder output = new StringBuilder();

        String[] input = new String[3];
        input[0] = Integer.toBinaryString(bytes[0]);
        input[1] = Integer.toBinaryString(bytes[1]);
        input[2] = Integer.toBinaryString(bytes[2]);

        String res = "";
        for(int i = 0; i < input.length; i++){
            if(input[i].length() < 6){
                input[i] = "0".repeat(6 - input[i].length()) + input[i];
            }
            res = res + input[i];
        }


        char[] charArray = (res).toCharArray();
        for(int i = 0; i < charArray.length-1; i += 2){
            switch (charArray[i]+""+ charArray[i+1]){
                case "00":
                    output.append("0");
                    break;
                case "01":
                    output.append("1");
                    break;
                case "10":
                    output.append("2");
                    break;
                case "11":
                    output.append("3");
            }
            if ((i-1)%3 == 0){
                output.append("\n");
            }
        }

        return output.toString();
    }
}
