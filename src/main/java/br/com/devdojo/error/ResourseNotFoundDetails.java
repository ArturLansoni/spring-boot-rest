package br.com.devdojo.error;

public class ResourseNotFoundDetails {
    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String developerMessage;

    private void ResourceNotFoundDetails(){

    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourseNotFoundDetails build() {
            ResourseNotFoundDetails resourseNotFoundDetails = new ResourseNotFoundDetails();
            resourseNotFoundDetails.status = this.status;
            resourseNotFoundDetails.timestamp = this.timestamp;
            resourseNotFoundDetails.detail = this.detail;
            resourseNotFoundDetails.title = this.title;
            resourseNotFoundDetails.developerMessage = this.developerMessage;
            return resourseNotFoundDetails;
        }
    }
}
