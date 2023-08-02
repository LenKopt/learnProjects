package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions implements Expression {

    public static Variable var(String name, int value) {
        Variable variable = new Variable(name, value);
        return variable;
    }

    public static Expression val(int value) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value >= 0) {
                    return "" + value;
                } else {
                    return "(" + value + ")";
                }
            }
        };
        return expression;
    }

    public static Expression sum(Expression... members) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (int i = 0; i < members.length; i++) {
                    sum = sum + members[i].evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String str = "(";
                for (int i = 0; i < members.length; i++) {
                    if (i != members.length-1) {
                        str = str + members[i].toExpressionString() + " + ";
                    } else {
                        str = str + members[i].toExpressionString() + ")";
                    }
                }
                return str;
            }
        };
        return expression;
    }

    public static Expression product(Expression... members) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int res = 1;
                for (int i = 0; i < members.length; i++) {
                    res = res * members[i].evaluate();
                }
                return res;
            }

            @Override
            public String toExpressionString() {
                String str = "(";
                for (int i = 0; i < members.length; i++) {
                    if (i != members.length-1) {
                        str = str + members[i].toExpressionString() + " * ";
                    } else {
                        str = str + members[i].toExpressionString() + ")";
                    }
                }
                return str;
            }
        };
        return expression;
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int res = 0;
                res = minuend.evaluate() - subtrahend.evaluate();
                return res;
            }

            @Override
            public String toExpressionString() {
                String str = "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString();

                return str + ")";
            }
        };
        return expression;
    }

    public static Expression fraction(Expression dividend, Expression divisor) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int res = 0;
                res = dividend.evaluate() / divisor.evaluate();
                return res;
            }

            @Override
            public String toExpressionString() {
                String str = "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString();

                return str + ")";
            }
        };
        return expression;
    }

    @Override
    public int evaluate() {
        return 0;
    }

    @Override
    public String toExpressionString() {
        return null;
    }
}
