package br.com.devdojo.error;

public class ResourseNotFoundDetails extends ErrorDetails {
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
            resourseNotFoundDetails.setStatus(status);
            resourseNotFoundDetails.setTimestamp(timestamp);
            resourseNotFoundDetails.setDetail(detail);
            resourseNotFoundDetails.setTitle(title);
            resourseNotFoundDetails.setDeveloperMessage(developerMessage);
            return resourseNotFoundDetails;
        }
    }
}
