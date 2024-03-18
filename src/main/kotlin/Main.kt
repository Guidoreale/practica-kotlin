import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

    fun esPrimo(numero: Int): String {
        var respuesta = ""
        if (numero < 2) respuesta = "el numero $numero No es primo" else {
            if (numero == 2) respuesta = "el numero $numero Es primo" else {
                for (i in 2..numero / 2) {
                    if (numero % i == 0) {
                        respuesta = "el numero $numero No es primo"
                        break
                    } else {
                        respuesta = "el numero $numero Es primo"
                    }
                }
            }
        }
        return respuesta
    }

    println(esPrimo(5))
    println(esPrimo(6))
    println(esPrimo(7))
    println(esPrimo(8))
    println(esPrimo(9))
    println(esPrimo(10))

    fun fizzBuzz() {
        for (i in 1..100) {
            val resultado = when {
                i % 3 == 0 && i % 5 == 0 -> "ab"
                i % 3 == 0 -> "a"
                i % 5 == 0 -> "b"
                else -> i.toString()
            }
            println(resultado)
        }
    }
    fizzBuzz()

    fun dividirEnteros(n: Int, m: Int): Float? {
        while (m == 0) return Float.NaN
        return n.toFloat() / m.toFloat()
    }
    println(dividirEnteros(5, 0))
    println(dividirEnteros(5, 2))
    println(dividirEnteros(5, 3))
    println(dividirEnteros(5, 4))

    /* sin refactorizar


    fun cifrarCesar(texto: String, clave: Int): String {
        val resultado = StringBuilder()

        for (caracter in texto) {
            when {
                (caracter.isLetter()) -> {
                    val codigo = caracter.code + clave
                    val nuevoCaracter = if (caracter.isLowerCase()) (codigo - 'a'.code) % 26 + 'a'.code else (codigo - 'A'.code) % 26 + 'A'.code
                    resultado.append(nuevoCaracter.toChar())
                }
                else -> {
                    resultado.append(caracter)
                }
            }
        }
            return resultado.toString()
        }

    val textoOriginal = "Hola Mundo!"
    val clave = 3
    val textoCifrado = cifrarCesar(textoOriginal, clave)
    println("Texto original: $textoOriginal")
    println("Texto cifrado: $textoCifrado")

     */

    //refactorizado

    fun String.ceasarCipher(clave: Int): String {
        val resultado = StringBuilder()

        for (caracter in this) {
            when {
                (caracter.isLetter()) -> {
                    val codigo = caracter.code + clave
                    val nuevoCaracter =
                        if (caracter.isLowerCase()) (codigo - 'a'.code) % 26 + 'a'.code else (codigo - 'A'.code) % 26 + 'A'.code
                    resultado.append(nuevoCaracter.toChar())
                }

                else -> {
                    resultado.append(caracter)
                }
            }
        }
        return resultado.toString()
    }

    fun String.ceasarDecrypt(shift: Int): String {
        return this.ceasarCipher(-shift)
    }

    val textoOriginal = "Hola Mundo!"
    val clave = 3
    val textoCifrado = textoOriginal.ceasarCipher(clave)
    println("Texto original: $textoOriginal")
    println("Texto cifrado: $textoCifrado")
    println("Texto descifrado: ${textoCifrado.ceasarDecrypt(clave)}")


    fun createPyramid(rows: Int) {
        for (filas in 1..rows) {
            for (columnas in 1..rows - filas) print(" ")
            for (columnas in 1..2 * filas - 1) print("*")
            println()
        }
    }
    createPyramid(5)
    createPyramid(3)
    createPyramid(7)

    fun stringOptions(array: Array<String>): String {
        val resultado = array.joinToString(prefix = "[", postfix = "]")
        return resultado
    }

    val array = arrayOf("hola", "mundo", "kotlin")
    println(stringOptions(array))

    fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
        val resultado = (if (toUpperCase) name.uppercase() else name) + number
        return resultado
    }
    println(foo("hola", 5, true))
    println(foo("hola", 5))
    println(foo("hola", toUpperCase = true))
    println(foo("hola"))


    fun String.removeFirstLastChar(): String {
        var start = 1
        var final = 0
        var newString = ""
        for (i in 0..this.length - 1) {
            when {
                this[i].isLetter() -> {
                    this.substring(i); start = i; break
                }
            }
        }
        for (i in this.length - 1 downTo 0) {
            when {
                this[i].isLetter() -> {
                    this.substring(i); final = i; break
                }
            }
        }
        if (start > 0 && final < this.length - 1)
            if (start <= final)
                newString = this.substring(0, start) + this.substring(start + 1, final) + this.substring(final + 1, this.length)
            else
                newString = this
        else
            if (start > 0) newString = this.substring(0, start) + this.substring(start + 1, final)
            else
                if (final < this.length - 1) newString = this.substring(start + 1, final) + this.substring(final + 1, this.length)
                else {
                    newString = this.substring(start + 1, final)
                }
        return newString
    }

    val array2 = "Hello Everyone"
    println(array2.removeFirstLastChar())

    fun Int.removeFirstLastDigit(): Int {
        val numberAsString = this.toString().substring(1, this.toString().length - 1)
        return numberAsString.toInt()
    }

    val number = 24556
    println(number.removeFirstLastDigit())

    infix fun Int.veces(numero: Int): Int {
        return this * numero
    }

    println(3 veces 2)

}