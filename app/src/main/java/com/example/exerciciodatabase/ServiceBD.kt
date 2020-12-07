package com.example.exerciciodatabase


interface Repository{

    //inserts
    suspend fun addContatoTask(gasto: Contato): List<Contato>

    //selects
    suspend fun getAllContatoTask(): List<Contato>

    //updates
    suspend fun updateAllContatoTask(): List<Contato>

    //deletes
    suspend fun deleteAllContatoTask()

}

class RepositoryImplementation(val contatoDAO: AccessContatos): Repository{
    override suspend fun addContatoTask(gasto: Contato): List<Contato> {
        contatoDAO.addContato(gasto)
        return contatoDAO.getAllContato()
    }

    override suspend fun getAllContatoTask() = contatoDAO.getAllContato()

    override suspend fun updateAllContatoTask(): List<Contato> {
        return contatoDAO.getAllContato()
    }

    override suspend fun deleteAllContatoTask() {
        contatoDAO.delAllContato()
    }
}
