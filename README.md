
# Edge Removal from an MST

**Author:** Adilzhan Zhumash

**Group:** SE-2422

## Project Description

This project demonstrates:

* Building a **Minimum Spanning Tree (MST)** using **Kruskal's algorithm**
* Removing one edge from the MST
* Identifying the resulting **components** after removal
* Finding a **replacement edge** to reconnect the components
* Displaying the **new MST** after reconnection

The program shows each step and prints which edges were removed and added to restore the MST.

---

## Requirements

* **Java 17**
* **Maven**

---

## How to Build and Run

1. **Clone the repository:**

```bash
git clone https://github.com/<your_username>/bonus.git
cd bonus
```

2. **Build the project with Maven:**

```bash
mvn clean package
```

This will create a JAR file in the `target/` folder, for example:
`target/mst-edge-replacement-1.0-SNAPSHOT.jar`

3. **Run the program:**

```bash
java -cp target/mst-edge-replacement-1.0-SNAPSHOT.jar 
```
## Program Output

The program prints:

* The original MST edges
* The removed edge from MST
* The components after removal
* The replacement edge chosen to reconnect the MST
* The new MST edges after reconnection
