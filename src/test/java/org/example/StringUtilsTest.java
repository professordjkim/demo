package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/***
 * Your goal is to write test cases substringsBetween using following strategy discussed in the lecture:
 Step 1: Understand method’s requirement, input types and output types (RIO)
 Step 2: Derive method’s expected program output for different inputs (based on requirement)
 Step 3: Pair input and output to derive test cases
 - Reduce when necessary
 * Refer to PPT slides for additional details.
 */
class StringUtilsTest {

    /**
     *
     * -- Partitions --
     * Single input (str, open, tag):
     *  - null
     *  - empty str
     *  - str == 1
     *  - str > 1
     *
     * Interaction:
     * - str !open !closed
     * - str !open closed
     * - str open !closed
     * - str open and closed
     * - str open and closed multiple
     *
     * Output:
     * - []
     * - null
     * - single character array
     * - multiple character array
     *
     * Output
     * -
     */
    @Test
    @DisplayName("Str null")
    void strIsNull(){
        /**
         * [null.null.null]
         * [null."".""]
         * [null."".null]
         * [null.null.""]
         * [null."".""]
         * [""."".null]
         * ["",null.null]
         */
        assertThat(StringUtils.substringsBetween(null,null,null)).isNull();
        assertThat(StringUtils.substringsBetween(null,"",null)).isNull();
        assertThat(StringUtils.substringsBetween(null,null,"")).isNull();

    }

    @Test
    @DisplayName("Str empty")
    void strIsEmpty() {
        /**
         * ["","",""]
         * ["","a",""]
         * ["","","b"]
         * ["","a","b"]
         */

        assertThat(StringUtils.substringsBetween("abc",null,"b")).isNull();
        assertThat(StringUtils.substringsBetween("","","")).isNull();
        assertThat(StringUtils.substringsBetween("","a","")).isNull();
        assertThat(StringUtils.substringsBetween("","","b")).isNull();
        assertThat(StringUtils.substringsBetween("","a","b")).isEqualTo(new String[]{});

    }

    @Test
    @DisplayName("Str: StrengthLength == 1, Opened: StrengthLength == 1, Closed: StrengthLength == 1")
    void strOfLength1() {
        /**
         * Interaction:
         * - str !open !closed
         * - str !open closed
         * - str open !closed
         * - str open and closed
         */
        /**
         * ["a","x",'y"]
         * ["a","x",'a"]
         * ["a","a",'y"]
         * ["a","a",'a"]
         */
        assertThat(StringUtils.substringsBetween("a","x","y")).isNull();
        assertThat(StringUtils.substringsBetween("a","x","a")).isNull();
        assertThat(StringUtils.substringsBetween("a","a","y")).isNull();
        assertThat(StringUtils.substringsBetween("a","a","y")).isNull();
        assertThat(StringUtils.substringsBetween("a","a","a")).isNull();
    }

    @Test
    @DisplayName("Str: StrengthLength > 1, Opened: StrengthLength == 1, Opened: StrengthLength == 1")
    void strOfLengthGreater1_openAndCloseOfLength1() {
        /**
         * Interaction:
         * - str !open !closed
         * - str !open closed
         * - str open !closed
         * - str open and closed
         */
        /**
         * ["ab","x,"y"]
         * ["ab","x,"b"]
         * ["ab","a,"y"]
         * ["ab","a,"b"]
         */
        assertThat(StringUtils.substringsBetween("ab","x","y")).isNull();
        assertThat(StringUtils.substringsBetween("ab","x","b")).isNull();
        assertThat(StringUtils.substringsBetween("ab","a","y")).isNull();
        assertThat(StringUtils.substringsBetween("ab","a","b")).isEqualTo(new String[]{""});
    }

    @Test
    @DisplayName("Str: StrengthLength > 1, Opened: StrengthLength > 1, Opened: StrengthLength > 1")
    void strOfLengthGreater1_openAndCloseOfGreater1() {
        /**
         * Interaction:
         * - str !open !closed
         * - str !open closed
         * - str open !closed
         * - str open and closed
         */
        /**
         * ["aaabbcc",xx","yy"]
         * ["aabbcc",xx","cc"]
         * ["aabbcc",aa","yy"]
         * ["aabbcc",aa","cc"]
         */
        assertThat(StringUtils.substringsBetween("aabbcc","xx","yy")).isNull();
        assertThat(StringUtils.substringsBetween("aabbcc","xx","cc")).isNull();
        assertThat(StringUtils.substringsBetween("aabbcc","aa","yy")).isNull();
        assertThat(StringUtils.substringsBetween("aabbcc","aa","cc")).isEqualTo(new String[]{"bb"});

    }

    @Test
    @DisplayName("We will do this next class - This is a boundary case")
    void noSubstringBetweenOpenAndCloseTags() {
        /**
         * ["aabbcc","aa","bb"]
         */
        assertThat(StringUtils.substringsBetween("aabbcc","aa","bb")).isEqualTo(new String[]{""});
    }
    }