package sf.com.marathon.utils;

import org.junit.Test;

import java.util.Date;

import static org.fest.assertions.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    public void should_ensure_string_is_empty() {
        assertThat(StringUtils.isEmpty("")).isTrue();
        assertThat(StringUtils.isEmpty(null)).isTrue();
        assertThat(StringUtils.isEmpty("1")).isFalse();
    }

    @Test
    public void should_ensure_string_is_not_empty() {
        assertThat(StringUtils.isNotEmpty("")).isFalse();
        assertThat(StringUtils.isNotEmpty(null)).isFalse();
        assertThat(StringUtils.isNotEmpty("123")).isTrue();
    }

    @Test
    public void should_ensure_string_is_format_as_mobile_number() {
        assertThat(StringUtils.isMobileNumber("123")).isFalse();
        assertThat(StringUtils.isMobileNumber("135")).isFalse();
        assertThat(StringUtils.isMobileNumber("13500062086")).isTrue();
        assertThat(StringUtils.isMobileNumber("135000620861")).isFalse();
        assertThat(StringUtils.isMobileNumber("")).isFalse();
    }

    @Test
    public void should_ensure_string_is_integer() {
        assertThat(StringUtils.isInteger("")).isFalse();
        assertThat(StringUtils.isInteger("1.1")).isFalse();
        assertThat(StringUtils.isInteger("23323")).isTrue();
        assertThat(StringUtils.isInteger(null)).isFalse();
    }

    @Test
    public void should_ensure_string_is_double() {
        assertThat(StringUtils.isDouble("")).isFalse();
        assertThat(StringUtils.isDouble("1")).isTrue();
        assertThat(StringUtils.isDouble("1.1")).isTrue();
        assertThat(StringUtils.isDouble(null)).isFalse();
    }

    @Test
    public void should_more_than_target_number() {
        assertThat(StringUtils.isBiggerThanAndEquals("11", 20)).isFalse();
        assertThat(StringUtils.isBiggerThanAndEquals("20", 20)).isTrue();
        assertThat(StringUtils.isBiggerThanAndEquals("21", 20)).isTrue();
    }

    @Test
    public void should_get_formatted_date() {
        assertThat(StringUtils.getFormatDate(new Date())).isEqualTo("12:15");
    }
}