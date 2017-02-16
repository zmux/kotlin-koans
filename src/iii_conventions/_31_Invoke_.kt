package iii_conventions

import util.TODO


class Invokable {
    private var numberOfInvocations = 0

    fun getNumberOfInvocations(): Int {
        return numberOfInvocations
    }

    operator fun invoke(): Invokable {
        incrementInvocations()
        return this
    }

    fun incrementInvocations() {
        numberOfInvocations += 1
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
