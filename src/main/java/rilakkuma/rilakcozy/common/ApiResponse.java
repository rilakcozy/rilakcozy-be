package rilakkuma.rilakcozy.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private long statusCode;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(long statusCode, String message, T data){
        return new ApiResponse<>(statusCode, message, data);
    }

    public static <T> ApiResponse<T> error(long statusCode, String message){
        return new ApiResponse<>(statusCode, message, null);
    }
}
