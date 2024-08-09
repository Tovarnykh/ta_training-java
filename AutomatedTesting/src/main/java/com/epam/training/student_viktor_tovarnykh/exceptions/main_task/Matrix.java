package com.epam.rd.qa.basicio;

/**
 * Encapsulates two-dimensional array-matrix block of real ({@code double}) type.
 * {@code Matrix} is the cover for two-dimensional array of real values, storing matrix
 * values with operations of matrix addition, deduction, and multiplication.
 */
public class Matrix {

    private final double[][] values;
    private final int rows;
    private final int cols;

    /**
     * Creates an empty matrix with predetermined number
     * of rows and columns (all values in matrix equal to 0)
     *
     * @param rows number of rows
     * @param cols number of columns
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(int rows, int cols) throws MatrixException {
        if (rows < 1 || cols < 1) {
            throw new MatrixException("");
        }
        this.rows = rows;
        this.cols = cols;
        this.values = new double[this.rows][this.cols];
    }

    /**
     * Creates a matrix based on existing two-dimensional array
     *
     * @param values two-dimensional array
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(double[][] values) {
        if (values.length < 1 || values[0].length < 1) {
            throw new MatrixException();
        }

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i].length != values[i + 1].length) {
                throw new MatrixException("Bad size of matrix");
            }
        }
        this.rows = values.length;
        this.cols = values[0].length;
        this.values = values;
    }

    /**
     * Returns count of matrix rows.
     *
     * @return count of rows in the matrix
     */
    public int getRows() throws MatrixException {
        if (this.values.length < 1) {
            throw new MatrixException("Bad size of matrix");
        }
        return this.values.length;
    }

    /**
     * Returns count of matrix columns
     *
     * @return count of columns in the matrix
     */
    public int getColumns() throws MatrixException {
        if (this.values[0].length < 1) {
            throw new MatrixException("Bad size of matrix");
        }
        return this.values[0].length;
    }

    /**
     * Returns an element via predetermined correct indexes.
     *
     * @param row row index
     * @param col column index
     * @return the element via indexes
     * @throws MatrixException if index out of bounds
     */
    public double get(int row, int col) throws MatrixException {
        if (row < 0 || col < 0 || row >= this.getRows() || col >= this.getColumns()) {
            throw new MatrixException("Bad size of matrix");
        }
        return this.values[row][col];
    }

    /**
     * Sets new value via predetermined correct indexes.
     *
     * @param row   row index
     * @param col   column index
     * @param value value to set
     * @throws MatrixException if index out of bounds
     */
    public void set(int row, int col, double value) {
        if (row < 0 || col < 0 || row >= this.getRows() || col >= this.getColumns()) {
            throw new MatrixException("You should check values before set");
        }
        this.values[row][col] = value;
    }

    /**
     * Returns standard two-dimensional array out of matrix.
     * Any changes in the returned array will be reflected to internal array.
     *
     * @return matrix values
     */
    public double[][] toArray() {
        return this.values;
    }
    /**
     * Adds all elements of {@code other} matrix to corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix add(Matrix other) throws MatrixException {
        if (this.getRows() != other.getRows() || this.getColumns() != other.getColumns()) {
            throw new MatrixException();
        }

        Matrix addMatrix = new Matrix(this.getRows(), this.getColumns());
        for (int r = 0; r < addMatrix.getRows(); r++) {
            for (int l = 0; l < addMatrix.getColumns(); l++) {
                addMatrix.set(r, l, this.get(r, l) + other.get(r, l));
            }
        }
        return addMatrix;
    }

    /**
     * Subtract all elements of {@code other} matrix from corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix subtract(Matrix other) throws MatrixException {
        if (this.getRows() != other.getRows() || this.getColumns() != other.getColumns()) {
            throw new MatrixException();
        }
        Matrix subtractMatrix = new Matrix(this.getRows(), other.getColumns());
        for (int r = 0; r < subtractMatrix.getRows(); r++) {
            for (int l = 0; l < subtractMatrix.getColumns(); l++) {
                subtractMatrix.set(r, l, this.get(r, l) - other.get(r, l));
            }
        }
        return subtractMatrix;
    }

    /**
     * Multiply this matrix to {@code other} matrix.<br/>
     * See
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">Matrix multiplication</a>
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm">Matrix multiplication algorithm</a>
     *
     * @param other another matrix
     * @return new matrix
     * @throws MatrixException if matrices have non-compliant sizes
     */
    public Matrix multiply(Matrix other) throws MatrixException {
        if (this.getColumns() != other.getRows()) {
            throw new MatrixException();
        }
        double[][] tempArray = new double[this.getRows()][other.getColumns()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                for (int k = 0; k < other.getRows(); k++) {
                    tempArray[i][j] += this.values[i][k] * other.get(k, j);
                }
            }
        }
        return new Matrix(tempArray);
    }

}
