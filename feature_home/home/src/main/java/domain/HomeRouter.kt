package domain

interface HomeRouter {
    suspend fun getProductsList():List<Unit>
}