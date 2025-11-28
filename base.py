import requests

BASE_URL = "http://localhost:8080"

def create_client(nom, prenom, adresse, codePostal, ville, telephone):
    payload = {
        "nom": nom,
        "prenom": prenom,
        "adresse": adresse,
        "codePostal": codePostal,
        "ville": ville,
        "telephone": telephone
    }
    response = requests.post(f"{BASE_URL}/clients", json=payload)
    print(f"Create client {nom} -> Status {response.status_code}")
    return response.json() if response.status_code == 200 else None


def create_compte_courant(clientId, solde):
    response = requests.post(
        f"{BASE_URL}/comptes/courant",
        params={"clientId": clientId, "solde": solde}
    )
    print(f"Create compte courant (client {clientId}) -> {response.status_code}")
    return response.json() if response.status_code == 200 else None


def virement(sourceId, destId, montant):
    payload = {
        "sourceId": sourceId,
        "destId": destId,
        "montant": montant
    }
    response = requests.post(f"{BASE_URL}/comptes/virement", json=payload)
    print(f"Virement {sourceId} -> {destId} : {montant}€ -> {response.status_code}")
    return

def create_agence():
    response = requests.post(
        f"{BASE_URL}/agences",
        json={ "identification": "AG001" }
    )
    print(f"Create agence -> {response.status_code}")
    return response.json() if response.status_code == 200 else None

def create_conseiller():
    response = requests.post(
        f"{BASE_URL}/conseillers?agenceId=AG001",
        json={"nom": "Le Conseiller", "prenom": "Test" }
    )
    print(f"Create cconseiller -> {response.status_code}")
    return None



if __name__ == "__main__":
    # --- Création des clients ---
    c1 = create_client(
        "Babin", "Anatole", "23 rue pasteur", "94001", "Le Kremelin Bicetre", "06 01 02 03 04"
    )
    c2 = create_client(
        "Lelievere", "Raphael", "24 rue pasteur", "94000", "Le KB", "07 01 02 03 04"
    )
    c3 = create_client(
       "c", "3", "xx", "xxx", "xx", "xxxxx"
    )
    c4 = create_client(
       "c", "4", "xx", "xxx", "xx", "xxxxx"
    )
    c5 = create_client(
       "c", "5", "xx", "xxx", "xx", "xxxxx"
    )

    c6 = create_client(
       "c", "6", "xx", "xxx", "xx", "xxxxx"
    )

    c7 = create_client(
       "c", "7", "xx", "xxx", "xx", "xxxxx"
    )
    c8 = create_client(
       "c", "8", "xx", "xxx", "xx", "xxxxx"
    )
    c9 = create_client(
       "c", "9", "xx", "xxx", "xx", "xxxxx"
    )
    c9 = create_client(
       "c", "9", "xx", "xxx", "xx", "xxxxx"
    )
    c10 = create_client(
       "c", "10", "xx", "xxx", "xx", "xxxxx"
    )
    c11 = create_client(
       "c", "11", "xx", "xxx", "xx", "xxxxx"
    )
    create_agence()
    create_conseiller()




    if not c1 or not c2:
        print("Erreur lors de la création des clients")
        exit()

    # Récupération des IDs créés automatiquement
    id1 = c1.get("id")
    id2 = c2.get("id")
    print("id===", id1)
    # --- Comptes courants ---
    create_compte_courant(id1, 15)
    create_compte_courant(id2, -6000)

    # virement(id2, id1, 50.0)

    print("\n✔ Toutes les requêtes ont été exécutées !")
