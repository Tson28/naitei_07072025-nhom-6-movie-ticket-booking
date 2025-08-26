package com.org.Movie_Ticket_Booking.exception;

public enum ErrorCode {
    UNIDENTIFIED_ERROR(1, "Lỗi không xác định"),
    USER_EXISTED(2, "Người dùng đã tồn tại"),
    WRONG_DATATYPE(3, "Lỗi kiểu dữ liệu"),
    INVALID_USERNAME(4, "Tên tài khoản không phù hợp"),
    AUTH_ACCOUNT_LOCKED(5, "Tài khoản đã bị khóa"),
    AUTH_EMAIL_NOT_VERIFIED(6, "Tài khoản chưa xác thực email"),
    AUTH_TOKEN_EXPIRED(7, "Token đã hết hạn"),
    AUTH_TOKEN_INVALID(8, "Token không hợp lệ"),
    USER_NOT_FOUND(9, "Không tìm thấy người dùng"),
    USER_EMAIL_EXISTS(10, "Email đã tồn tại"),
    USER_PHONE_EXISTS(11, "Số điện thoại đã tồn tại"),
    MOVIE_NOT_FOUND(12, "Không tìm thấy phim"),
    GENRE_NOT_FOUND(13, "Không tìm thấy thể loại"),
    SHOWTIME_NOT_FOUND(14, "Không tìm thấy suất chiếu"),
    BOOKING_NOT_FOUND(15, "Không tìm thấy thông tin đặt vé"),
    BOOKING_ALREADY_PAID(16, "Vé đã được thanh toán, không thể hủy"),
    BOOKING_SEAT_UNAVAILABLE(17, "Ghế đã được đặt"),
    BOOKING_PAYMENT_FAILED(18, "Thanh toán thất bại"),
    BOOKING_CANCEL_FAILED(19, "Hủy vé thất bại"),
    PAYMENT_METHOD_INVALID(20, "Phương thức thanh toán không hợp lệ"),
    PAYMENT_AMOUNT_MISMATCH(21, "Số tiền thanh toán không khớp"),
    PROMO_CODE_INVALID(23, "Mã giảm giá không hợp lệ"),
    PROMO_CODE_EXPIRED(24, "Mã giảm giá đã hết hạn"),
    PROMO_CODE_LIMIT_REACHED(25, "Mã giảm giá đã hết lượt sử dụng"),
    ROOM_NOT_FOUND(26, "Không tìm thấy phòng chiếu"),
    SEAT_NOT_FOUND(27, "Không tìm thấy ghế"),
    REQUEST_INVALID(28, "Yêu cầu không hợp lệ"),
    DATA_NOT_FOUND(29, "Không tìm thấy dữ liệu"),
    INTERNAL_ERROR(30, "Lỗi hệ thống, vui lòng thử lại sau"),
    PERMISSION_DENIED(31, "Bạn không có quyền thực hiện thao tác này"),
    INVALID_PASSWORD(32, "Mật khẩu không hợp lệ"),
    METHOD_NOTSUPPORT(33, "Không hỗ trợ http method cho endpoint này"),
    INVALID_INPUT(34, "Dữ liệu nhập vào không hợp lệ"),
    INVALID_CREDENTIALS(35, "Tên đăng nhập hoặc mật khẩu không đúng"),
    FILE_ERROR (36,"Lỗi khi đọc file"),
    FILE_INVALID(37,"Định dạng file không hợp lệ"),
    BUSINESS_ERROR(38, "Lỗi nghiệp vụ"),
    FILE_UPLOAD_FAILED(39, "Upload file thất bại. Vui lòng thử lại."),
    INVALID_DATA(40, "Dữ liệu không hợp lệ"),
    MISSING_DATA_COLUMN(41, "Thiếu dữ liệu tại cột"),
    MOVIE_TITLE_NULL(42, "Tiêu đề phim bị trống"),
    DATE_INVALID(43, "Ngày sai định dạng "),
    DURATION_INVALID(44, "Thời lượng phải là số nguyên "),
    UPGRADE_EXISTING_PENDING(45, "Bạn đã gửi yêu cầu này và đang chờ duyệt"),
    UPGRADE_APPROVED(46, "Rạp này của bạn đã được phê duyệt, không thể gửi thêm"),
    UPGRADE_EXISTING(47, "Rạp này đã được đăng kí, vui lòng điền thông tin khác"),
    REQUEST_NOT_FOUND(48, "Không tìm thấy yêu cầu đăng ký này"),
    ROLE_NOT_FOUND(49, "Không tìm thấy role"),
    INVALID_STATUS(50, "Trạng thái yêu cầu không hợp lệ"),
    DATABASE_ERROR(51, "Database gặp lỗi");

    private int code;
    private String massage;

    ErrorCode(int code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
